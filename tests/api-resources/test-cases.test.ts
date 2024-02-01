// File generated from our OpenAPI spec by Stainless.

import MeorphisTest2Vbs6wj from 'meorphis-test-2-vbs6wj';
import { Response } from 'node-fetch';

const meorphisTest2Vbs6wj = new MeorphisTest2Vbs6wj({
  baseURL: process.env['TEST_API_BASE_URL'] ?? 'http://127.0.0.1:4010',
});

describe('resource testCases', () => {
  test('retrieve', async () => {
    const responsePromise = meorphisTest2Vbs6wj.testCases.retrieve();
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
    await expect(
      meorphisTest2Vbs6wj.testCases.retrieve({ path: '/_stainless_unknown_path' }),
    ).rejects.toThrow(MeorphisTest2Vbs6wj.NotFoundError);
  });

  test('retrieve: request options and params are passed correctly', async () => {
    // ensure the request options are being passed correctly by passing an invalid HTTP method in order to cause an error
    await expect(
      meorphisTest2Vbs6wj.testCases.retrieve(
        { pipelineId: '182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e', pipelineSlug: 'string' },
        { path: '/_stainless_unknown_path' },
      ),
    ).rejects.toThrow(MeorphisTest2Vbs6wj.NotFoundError);
  });
});
