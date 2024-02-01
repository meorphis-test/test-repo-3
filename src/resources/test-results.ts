// File generated from our OpenAPI spec by Stainless.

import * as Core from 'meorphis-test-2-vbs6wj/core';
import { APIResource } from 'meorphis-test-2-vbs6wj/resource';
import * as TestResultsAPI from 'meorphis-test-2-vbs6wj/resources/test-results';

export class TestResults extends APIResource {
  /**
   * Create a new test result from runs
   */
  create(
    body: TestResultCreateParams,
    options?: Core.RequestOptions,
  ): Core.APIPromise<TestResultCreateResponse> {
    return this._client.post('/test-result', { body, ...options });
  }

  /**
   * Get test result by ID
   */
  retrieve(
    query: TestResultRetrieveParams,
    options?: Core.RequestOptions,
  ): Core.APIPromise<TestResultRetrieveResponse> {
    return this._client.get('/test-result', { query, ...options });
  }
}

export interface TestResult {
  /**
   * The unique identifier for the test result.
   */
  id?: string;

  /**
   * The branch that the test result was created from
   */
  branch?: string;

  /**
   * The commit that the test result was created from
   */
  commit?: string;

  /**
   * The date and time the test result was created.
   */
  createdAt?: string;

  /**
   * The name of the test result
   */
  name?: string;

  /**
   * The unique identifier for the pipeline associated with the test result.
   */
  pipelineId?: string;

  /**
   * The date and time the test result was last updated.
   */
  updatedAt?: string;
}

export interface TestResultCreateResponse {
  resultId: string;
}

export interface TestResultRetrieveResponse {
  stats?: TestResultRetrieveResponse.Stats;

  /**
   * The test result object.
   */
  testResult?: TestResult;
}

export namespace TestResultRetrieveResponse {
  export interface Stats {
    done: number;

    failure: number;

    pending: number;

    total: number;
  }
}

export interface TestResultCreateParams {
  testRuns: Array<TestResultCreateParams.TestRun>;

  /**
   * The branch that the test result was created from
   */
  branch?: string | null;

  /**
   * The method used to collect the test runs
   */
  collectionMethod?: 'manual' | 'runner';

  /**
   * The commit that the test result was created from
   */
  commit?: string | null;

  /**
   * The name of the test result
   */
  name?: string | null;

  /**
   * The pipeline ID to create the test result for. Only one of pipelineSlug or
   * pipelineId is required.
   */
  pipelineId?: string;

  /**
   * The pipeline slug to create the test result for. Only one of pipelineSlug or
   * pipelineId is required.
   */
  pipelineSlug?: string;
}

export namespace TestResultCreateParams {
  export interface TestRun {
    /**
     * The ID of the test case
     */
    caseId: string;

    /**
     * Use outputs.steps insteads.
     */
    stepRuns: Array<TestRun.StepRun>;

    /**
     * The ID of the test run
     */
    id?: string | null;
  }

  export namespace TestRun {
    export interface StepRun {
      elapsedTime?: number;

      endTime?: string;

      provider?: StepRun.Provider;

      startTime?: string;
    }

    export namespace StepRun {
      export interface Provider {
        inputs?: Record<string, unknown>;

        invocation?: string;

        modelParams?: Record<string, unknown>;

        name?: string;

        outputs?: Record<string, unknown>;
      }
    }
  }
}

export interface TestResultRetrieveParams {
  /**
   * The ID of the test result to retrieve
   */
  resultId: string;
}

export namespace TestResults {
  export import TestResult = TestResultsAPI.TestResult;
  export import TestResultCreateResponse = TestResultsAPI.TestResultCreateResponse;
  export import TestResultRetrieveResponse = TestResultsAPI.TestResultRetrieveResponse;
  export import TestResultCreateParams = TestResultsAPI.TestResultCreateParams;
  export import TestResultRetrieveParams = TestResultsAPI.TestResultRetrieveParams;
}
