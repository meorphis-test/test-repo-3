// File generated from our OpenAPI spec by Stainless.

import * as Core from 'meorphis-test-2-vbs6wj/core';
import { APIResource } from 'meorphis-test-2-vbs6wj/resource';
import * as FeedbacksAPI from 'meorphis-test-2-vbs6wj/resources/feedbacks';

export class Feedbacks extends APIResource {
  /**
   * Submit feedback for a run
   */
  create(body: FeedbackCreateParams, options?: Core.RequestOptions): Core.APIPromise<FeedbackCreateResponse> {
    return this._client.post('/feedback', { body, ...options });
  }
}

export interface FeedbackCreateResponse {
  message: string;
}

export interface FeedbackCreateParams {
  pipelineRunId: string;

  recordedTime: string;

  score: number;

  details?: string | null;
}

export namespace Feedbacks {
  export import FeedbackCreateResponse = FeedbacksAPI.FeedbackCreateResponse;
  export import FeedbackCreateParams = FeedbacksAPI.FeedbackCreateParams;
}
