// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.configure_me_meorphis_test_6.api.services.blocking

import com.configure_me_meorphis_test_6.api.core.RequestOptions
import com.configure_me_meorphis_test_6.api.models.AccountRetrieveParams
import com.configure_me_meorphis_test_6.api.models.AccountRetrieveResponse
import com.configure_me_meorphis_test_6.api.models.AccountUpdateParams
import com.configure_me_meorphis_test_6.api.models.AccountUpdateResponse
import com.configure_me_meorphis_test_6.api.services.blocking.accounts.CreditConfigurationService

interface AccountService {

    fun creditConfigurations(): CreditConfigurationService

    /** Get account configuration such as spend limits. */
    @JvmOverloads
    fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountRetrieveResponse

    /**
     * Update account configuration such as spend limits and verification address. Can only be run
     * on accounts that are part of the program managed by this API key.
     *
     * Accounts that are in the `PAUSED` state will not be able to transact or create new cards.
     */
    @JvmOverloads
    fun update(
        params: AccountUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountUpdateResponse
}
