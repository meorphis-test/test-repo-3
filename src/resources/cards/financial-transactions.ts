// File generated from our OpenAPI spec by Stainless.

import * as Core from 'meorphis-test-3-hp2m8u/core';
import { APIResource } from 'meorphis-test-3-hp2m8u/resource';
import * as CardsAPI from 'meorphis-test-3-hp2m8u/resources/cards/cards';

export class FinancialTransactions extends APIResource {
  /**
   * Get the card financial transaction for the provided token.
   */
  retrieve(
    cardToken: string,
    financialTransactionToken: string,
    options?: Core.RequestOptions,
  ): Core.APIPromise<CardsAPI.FinancialTransaction> {
    return this._client.get(
      `/cards/${cardToken}/financial_transactions/${financialTransactionToken}`,
      options,
    );
  }
}
