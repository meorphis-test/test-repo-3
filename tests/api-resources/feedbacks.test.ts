// File generated from our OpenAPI spec by Stainless.

import MeorphisTest2Vbs6wj from 'meorphis-test-2-vbs6wj';
import { Response } from 'node-fetch';

const meorphisTest2Vbs6wj = new MeorphisTest2Vbs6wj({
  baseURL: process.env['TEST_API_BASE_URL'] ?? 'http://127.0.0.1:4010',
});

describe('resource feedbacks', () => {
  test('create: only required params', async () => {
    const responsePromise = meorphisTest2Vbs6wj.feedbacks.create({
      pipelineRunId: '182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e',
      recordedTime: '2019-12-27T18:11:19.117Z',
      score: 0,
    });
    const rawResponse = await responsePromise.asResponse();
    expect(rawResponse).toBeInstanceOf(Response);
    const response = await responsePromise;
    expect(response).not.toBeInstanceOf(Response);
    const dataAndResponse = await responsePromise.withResponse();
    expect(dataAndResponse.data).toBe(response);
    expect(dataAndResponse.response).toBe(rawResponse);
  });

  test('create: required and optional params', async () => {
    const response = await meorphisTest2Vbs6wj.feedbacks.create({
      pipelineRunId: '182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e',
      recordedTime: '2019-12-27T18:11:19.117Z',
      score: 0,
      details: 'string',
    });
  });
});
