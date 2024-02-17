# Meorphis Test 6 Java API Library

[![Maven Central](https://img.shields.io/maven-central/v/com.configure_me_meorphis_test_6.api/meorphis-test-6-java)](https://central.sonatype.com/artifact/com.configure_me_meorphis_test_6.api/meorphis-test-6-java/0.0.1-alpha.0)

The Meorphis Test 6 Java SDK provides convenient access to the Meorphis Test 6 REST API from applications written in Java. It includes helper classes with helpful types and documentation for every request and response property.

The Meorphis Test 6 Java SDK is similar to the Meorphis Test 6 Kotlin SDK but with minor differences that make it more ergonomic for use in Java, such as `Optional` instead of nullable values, `Stream` instead of `Sequence`, and `CompletableFuture` instead of suspend functions.

## Documentation

The REST API documentation can be found [on docs.meorphis-test-6.com](https://docs.meorphis-test-6.com). The full API of this library can be found in [api.md](api.md).

---

## Getting started

### Install dependencies

#### Gradle

```kotlin
implementation("com.configure_me_meorphis_test_6.api:meorphis-test-6-java:0.0.1-alpha.0")
```

#### Maven

```xml
<dependency>
    <groupId>com.configure_me_meorphis_test_6.api</groupId>
    <artifactId>meorphis-test-6-java</artifactId>
    <version>0.0.1-alpha.0</version>
</dependency>
```

### Configure the client

Use `MeorphisTest6OkHttpClient.builder()` to configure the client. At a minimum you need to set `.apiKey()`:

```java
import com.configure_me_meorphis_test_6.api.client.MeorphisTest6Client;
import com.configure_me_meorphis_test_6.api.client.okhttp.MeorphisTest6OkHttpClient;

MeorphisTest6Client client = MeorphisTest6OkHttpClient.builder()
    .apiKey("My API Key")
    .build();
```

Alternately, set the environment with `MEORPHIS_TEST_6_API_KEY`, and use `MeorphisTest6OkHttpClient.fromEnv()` to read from the environment.

```java
MeorphisTest6Client client = MeorphisTest6OkHttpClient.fromEnv();

// Note: you can also call fromEnv() from the client builder, for example if you need to set additional properties
MeorphisTest6Client client = MeorphisTest6OkHttpClient.builder()
    .fromEnv()
    // ... set properties on the builder
    .build();
```

| Property | Environment variable      | Required | Default value |
| -------- | ------------------------- | -------- | ------------- |
| apiKey   | `MEORPHIS_TEST_6_API_KEY` | true     | —             |

Read the documentation for more configuration options.

---

### Example: creating a resource

To create a new account, first use the `AccountRetrieveParams` builder to specify attributes,
then pass that to the `retrieve` method of the `accounts` service.

```java
import com.configure_me_meorphis_test_6.api.models.AccountRetrieveParams;
import com.configure_me_meorphis_test_6.api.models.AccountRetrieveResponse;

AccountRetrieveParams params = AccountRetrieveParams.builder().build();
AccountRetrieveResponse accountRetrieveResponse = client.accounts().retrieve(params);
```

---

## Requests

### Parameters and bodies

To make a request to the Meorphis Test 6 API, you generally build an instance of the appropriate `Params` class.

In [Example: creating a resource](#example-creating-a-resource) above, we used the `AccountRetrieveParams.builder()` to pass to
the `retrieve` method of the `accounts` service.

Sometimes, the API may support other properties that are not yet supported in the Java SDK types. In that case,
you can attach them using the `putAdditionalProperty` method.

```java
AccountRetrieveParams params = AccountRetrieveParams.builder()
    // ... normal properties
    .putAdditionalProperty("secret_param", "4242")
    .build();
```

## Responses

### Response validation

When receiving a response, the Meorphis Test 6 Java SDK will deserialize it into instances of the typed model classes. In rare cases, the API may return a response property that doesn't match the expected Java type. If you directly access the mistaken property, the SDK will throw an unchecked `MeorphisTest6InvalidDataException` at runtime. If you would prefer to check in advance that that response is completely well-typed, call `.validate()` on the returned model.

```java
AccountRetrieveResponse accountRetrieveResponse = client.accounts().retrieve().validate();
```

### Response properties as JSON

In rare cases, you may want to access the underlying JSON value for a response property rather than using the typed version provided by
this SDK. Each model property has a corresponding JSON version, with an underscore before the method name, which returns a `JsonField` value.

```java
JsonField field = responseObj._field();

if (field.isMissing()) {
  // Value was not specified in the JSON response
} else if (field.isNull()) {
  // Value was provided as a literal null
} else {
  // See if value was provided as a string
  Optional<String> jsonString = field.asString();

  // If the value given by the API did not match the shape that the SDK expects
  // you can deserialise into a custom type
  MyClass myObj = responseObj._field().asUnknown().orElseThrow().convert(MyClass.class);
}
```

### Additional model properties

Sometimes, the server response may include additional properties that are not yet available in this library's types. You can access them using the model's `_additionalProperties` method:

```java
JsonValue secret = accountRetrieveResponse._additionalProperties().get("secret_field");
```

---

---

## Error handling

This library throws exceptions in a single hierarchy for easy handling:

- **`MeorphisTest6Exception`** - Base exception for all exceptions

  - **`MeorphisTest6ServiceException`** - HTTP errors with a well-formed response body we were able to parse. The exception message and the `.debuggingRequestId()` will be set by the server.

    | 400    | BadRequestException           |
    | ------ | ----------------------------- |
    | 401    | AuthenticationException       |
    | 403    | PermissionDeniedException     |
    | 404    | NotFoundException             |
    | 422    | UnprocessableEntityException  |
    | 429    | RateLimitException            |
    | 5xx    | InternalServerException       |
    | others | UnexpectedStatusCodeException |

  - **`MeorphisTest6IoException`** - I/O networking errors
  - **`MeorphisTest6InvalidDataException`** - any other exceptions on the client side, e.g.:
    - We failed to serialize the request body
    - We failed to parse the response body (has access to response code and body)

## Network options

### Retries

Requests that experience certain errors are automatically retried 2 times by default, with a short exponential backoff. Connection errors (for example, due to a network connectivity problem), 408 Request Timeout, 409 Conflict, 429 Rate Limit, and >=500 Internal errors will all be retried by default.
You can provide a `maxRetries` on the client builder to configure this:

```java
MeorphisTest6Client client = MeorphisTest6OkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 1 minute by default. You can configure this on the client builder:

```java
MeorphisTest6Client client = MeorphisTest6OkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build();
```

### Proxies

Requests can be routed through a proxy. You can configure this on the client builder:

```java
MeorphisTest6Client client = MeorphisTest6OkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(
        Type.HTTP,
        new InetSocketAddress("proxy.com", 8080)
    ))
    .build();
```

### Environments

Requests are made to the production environment by default. You can connect to other environments, like `environment_1`, via the client builder:

```java
MeorphisTest6Client client = MeorphisTest6OkHttpClient.builder()
    .fromEnv()
    .environment1()
    .build();
```

## Semantic Versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals)_.
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/meorphis-test/meorphis-test-6-java/issues) with questions, bugs, or suggestions.
