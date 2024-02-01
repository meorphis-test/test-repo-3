// File generated from our OpenAPI spec by Stainless.

import * as Core from 'meorphis-test-2-vbs6wj/core';
import { APIResource } from 'meorphis-test-2-vbs6wj/resource';
import * as RunsAPI from 'meorphis-test-2-vbs6wj/resources/runs';

export class Runs extends APIResource {
  /**
   * Create a run
   */
  create(body: RunCreateParams, options?: Core.RequestOptions): Core.APIPromise<RunCreateResponse> {
    return this._client.post('/run', { body, ...options });
  }
}

export interface RunCreateResponse {
  pipelineRunId?: string;
}

export interface RunCreateParams {
  id: string;

  stepRuns: Array<RunCreateParams.StepRun>;

  /**
   * The method used to collect the run
   */
  collectionMethod?: 'manual' | 'runner';

  name?: string;

  slug?: string;
}

export namespace RunCreateParams {
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

export namespace Runs {
  export import RunCreateResponse = RunsAPI.RunCreateResponse;
  export import RunCreateParams = RunsAPI.RunCreateParams;
}
