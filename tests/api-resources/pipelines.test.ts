// File generated from our OpenAPI spec by Stainless.

import MeorphisTest2Vbs6wj from 'meorphis-test-2-vbs6wj';
import { Response } from 'node-fetch';

const meorphisTest2Vbs6wj = new MeorphisTest2Vbs6wj({
  baseURL: process.env['TEST_API_BASE_URL'] ?? 'http://127.0.0.1:4010',
});

describe('resource pipelines', () => {
  test('list', async () => {
    const responsePromise = meorphisTest2Vbs6wj.pipelines.list();
    const rawResponse = await responsePromise.asResponse();
    expect(rawResponse).toBeInstanceOf(Response);
    const response = await responsePromise;
    expect(response).not.toBeInstanceOf(Response);
    const dataAndResponse = await responsePromise.withResponse();
    expect(dataAndResponse.data).toBe(response);
    expect(dataAndResponse.response).toBe(rawResponse);
  });

  test('list: request options instead of params are passed correctly', async () => {
    // ensure the request options are being passed correctly by passing an invalid HTTP method in order to cause an error
    await expect(meorphisTest2Vbs6wj.pipelines.list({ path: '/_stainless_unknown_path' })).rejects.toThrow(
      MeorphisTest2Vbs6wj.NotFoundError,
    );
  });

  test('list: request options and params are passed correctly', async () => {
    // ensure the request options are being passed correctly by passing an invalid HTTP method in order to cause an error
    await expect(
      meorphisTest2Vbs6wj.pipelines.list(
        { label: 'string', slug: 'string' },
        { path: '/_stainless_unknown_path' },
      ),
    ).rejects.toThrow(MeorphisTest2Vbs6wj.NotFoundError);
  });
});
