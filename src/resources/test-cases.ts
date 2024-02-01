// File generated from our OpenAPI spec by Stainless.

import * as Core from 'meorphis-test-2-vbs6wj/core';
import { APIResource } from 'meorphis-test-2-vbs6wj/resource';
import { isRequestOptions } from 'meorphis-test-2-vbs6wj/core';
import * as TestCasesAPI from 'meorphis-test-2-vbs6wj/resources/test-cases';

export class TestCases extends APIResource {
  /**
   * Get test cases for a pipeline
   */
  retrieve(
    query?: TestCaseRetrieveParams,
    options?: Core.RequestOptions,
  ): Core.APIPromise<TestCaseRetrieveResponse>;
  retrieve(options?: Core.RequestOptions): Core.APIPromise<TestCaseRetrieveResponse>;
  retrieve(
    query: TestCaseRetrieveParams | Core.RequestOptions = {},
    options?: Core.RequestOptions,
  ): Core.APIPromise<TestCaseRetrieveResponse> {
    if (isRequestOptions(query)) {
      return this.retrieve({}, query);
    }
    return this._client.get('/test-case', { query, ...options });
  }
}

export interface TestCaseRetrieveResponse {
  testCases?: Array<TestCaseRetrieveResponse.TestCase>;
}

export namespace TestCaseRetrieveResponse {
  export interface TestCase {
    /**
     * The ID of the test case
     */
    id: string;

    /**
     * The date and time when the test case was created
     */
    createdAt: string;

    /**
     * The input data for the test case as a JSON object
     */
    inputs: Record<string, unknown>;

    /**
     * The name of the test case
     */
    name: string;

    /**
     * The ID of the pipeline that the test case belongs to
     */
    pipelineId: string;

    /**
     * The date and time when the test case was last updated
     */
    updatedAt: string;

    /**
     * The date and time when the test case was archived, can be null if the test case
     * has not been archived
     */
    archivedAt?: string | null;

    /**
     * The expected outputs for the test case
     */
    expectedOutputs?: unknown | null;

    /**
     * The ID of the set (now pipeline) that the test case belongs to
     */
    setId?: string;
  }
}

export interface TestCaseRetrieveParams {
  /**
   * The ID of the Pipeline to retrieve test cases for
   */
  pipelineId?: string;

  /**
   * The slug of the Pipeline to retrieve test cases for
   */
  pipelineSlug?: string;
}

export namespace TestCases {
  export import TestCaseRetrieveResponse = TestCasesAPI.TestCaseRetrieveResponse;
  export import TestCaseRetrieveParams = TestCasesAPI.TestCaseRetrieveParams;
}
