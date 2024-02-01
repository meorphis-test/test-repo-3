// File generated from our OpenAPI spec by Stainless.

import * as Core from 'meorphis-test-2-vbs6wj/core';
import { APIResource } from 'meorphis-test-2-vbs6wj/resource';
import { isRequestOptions } from 'meorphis-test-2-vbs6wj/core';
import * as PipelinesAPI from 'meorphis-test-2-vbs6wj/resources/pipelines';

export class Pipelines extends APIResource {
  /**
   * Get pipelines, optionally filtered by label
   */
  list(query?: PipelineListParams, options?: Core.RequestOptions): Core.APIPromise<PipelineListResponse>;
  list(options?: Core.RequestOptions): Core.APIPromise<PipelineListResponse>;
  list(
    query: PipelineListParams | Core.RequestOptions = {},
    options?: Core.RequestOptions,
  ): Core.APIPromise<PipelineListResponse> {
    if (isRequestOptions(query)) {
      return this.list({}, query);
    }
    return this._client.get('/pipelines', { query, ...options });
  }
}

export interface PipelineListResponse {
  pipelines: Array<PipelineListResponse.Pipeline>;
}

export namespace PipelineListResponse {
  export interface Pipeline {
    /**
     * The ID of the pipeline
     */
    id: string;

    /**
     * The array of test cases that belong to the pipeline
     */
    cases: Array<Pipeline.Case>;

    /**
     * The date and time when the pipeline was created
     */
    createdAt: string;

    /**
     * The labels attached to the pipeline
     */
    labels: Array<string>;

    /**
     * The ID of the organization that owns the pipeline
     */
    organizationId: string;

    /**
     * The slug of the pipeline
     */
    slug: string;

    /**
     * The date and time when the pipeline was last updated
     */
    updatedAt: string;

    /**
     * The date and time when the pipeline was archived, can be null if the pipeline
     * has not been archived
     */
    archivedAt?: string | null;

    /**
     * The branch that the pipeline is associated with
     */
    branch?: string | null;

    /**
     * The name of the pipeline
     */
    displayName?: string | null;
  }

  export namespace Pipeline {
    export interface Case {
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
}

export interface PipelineListParams {
  /**
   * The label to filter pipelines by
   */
  label?: string;

  /**
   * The slug to filter pipelines by
   */
  slug?: string;
}

export namespace Pipelines {
  export import PipelineListResponse = PipelinesAPI.PipelineListResponse;
  export import PipelineListParams = PipelinesAPI.PipelineListParams;
}
