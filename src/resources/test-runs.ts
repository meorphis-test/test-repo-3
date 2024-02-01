// File generated from our OpenAPI spec by Stainless.

import * as Core from 'meorphis-test-2-vbs6wj/core';
import { APIResource } from 'meorphis-test-2-vbs6wj/resource';
import * as TestRunsAPI from 'meorphis-test-2-vbs6wj/resources/test-runs';

export class TestRuns extends APIResource {
  /**
   * Create a new test run from test results
   */
  create(body: TestRunCreateParams, options?: Core.RequestOptions): Core.APIPromise<TestRunCreateResponse> {
    return this._client.post('/test-run', { body, ...options });
  }

  /**
   * Get test run by ID
   */
  retrieve(
    query: TestRunRetrieveParams,
    options?: Core.RequestOptions,
  ): Core.APIPromise<TestRunRetrieveResponse> {
    return this._client.get('/test-run', { query, ...options });
  }
}

export interface TestRun {
  /**
   * The unique identifier for the test run.
   */
  id?: string;

  /**
   * The branch that the test run was created from
   */
  branch?: string;

  /**
   * The commit that the test run was created from
   */
  commit?: string;

  /**
   * The date and time the test run was created.
   */
  createdAt?: string;

  /**
   * The name of the test run
   */
  name?: string;

  /**
   * The unique identifier for the test set associated with the test run.
   */
  setId?: string;

  /**
   * The date and time the test run was last updated.
   */
  updatedAt?: string;
}

export interface TestRunCreateResponse {
  runId: string;
}

export interface TestRunRetrieveResponse {
  stats?: TestRunRetrieveResponse.Stats;

  /**
   * The test run object.
   */
  testRun?: TestRun;
}

export namespace TestRunRetrieveResponse {
  export interface Stats {
    done: number;

    failure: number;

    pending: number;

    total: number;
  }
}

export interface TestRunCreateParams {
  /**
   * The ID of the test case set to run
   */
  setId: string;

  testResults: Array<TestRunCreateParams.TestResult>;

  /**
   * The branch that the test run was created from
   */
  branch?: string | null;

  /**
   * The commit that the test run was created from
   */
  commit?: string | null;

  /**
   * The name of the test run
   */
  name?: string | null;
}

export namespace TestRunCreateParams {
  export interface TestResult {
    /**
     * The ID of the test case
     */
    caseId: string;

    /**
     * The input data for the test case
     */
    inputs: Record<string, unknown>;

    /**
     * The ID of the test result
     */
    id?: string | null;

    /**
     * Use outputs object instead.
     */
    output?: string;

    /**
     * The returned outputs for the test case
     */
    outputs?: Record<string, unknown>;

    /**
     * Use outputs.steps insteads.
     */
    outputSteps?: Array<TestResult.OutputStep> | null;
  }

  export namespace TestResult {
    export interface OutputStep {
      /**
       * The key of the step
       */
      key: string;

      /**
       * The output of the step
       */
      output: string;

      /**
       * The inputs of the step
       */
      inputs?: Record<string, string> | null;
    }
  }
}

export interface TestRunRetrieveParams {
  /**
   * The ID of the test run to retrieve
   */
  runId: string;
}

export namespace TestRuns {
  export import TestRun = TestRunsAPI.TestRun;
  export import TestRunCreateResponse = TestRunsAPI.TestRunCreateResponse;
  export import TestRunRetrieveResponse = TestRunsAPI.TestRunRetrieveResponse;
  export import TestRunCreateParams = TestRunsAPI.TestRunCreateParams;
  export import TestRunRetrieveParams = TestRunsAPI.TestRunRetrieveParams;
}
