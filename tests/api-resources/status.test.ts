// File generated from our OpenAPI spec by Stainless.

import MeorphisTest3Hp2m8u from 'meorphis-test-3-hp2m8u';
import { Response } from 'node-fetch';

const meorphisTest3Hp2m8u = new MeorphisTest3Hp2m8u({
  apiKey: 'My API Key',
  baseURL: process.env['TEST_API_BASE_URL'] ?? 'http://127.0.0.1:4010',
});

describe('resource status', () => {
  test('retrieve', async () => {
    const responsePromise = meorphisTest3Hp2m8u.status.retrieve();
    const rawResponse = await responsePromise.asResponse();
    expect(rawResponse).toBeInstanceOf(Response);
    const response = await responsePromise;
    expect(response).not.toBeInstanceOf(Response);
    const dataAndResponse = await responsePromise.withResponse();
    expect(dataAndResponse.data).toBe(response);
    expect(dataAndResponse.response).toBe(rawResponse);
  });

  test('retrieve: request options instead of params are passed correctly', async () => {
    // ensure the request options are being passed correctly by passing an invalid HTTP method in order to cause an error
    await expect(meorphisTest3Hp2m8u.status.retrieve({ path: '/_stainless_unknown_path' })).rejects.toThrow(
      MeorphisTest3Hp2m8u.NotFoundError,
    );
  });
});
