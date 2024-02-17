// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.configure_me_meorphis_test_6.api.services.async.accounts

import com.configure_me_meorphis_test_6.api.core.RequestOptions
import com.configure_me_meorphis_test_6.api.models.AccountCreditConfigurationListParams
import com.configure_me_meorphis_test_6.api.models.AccountCreditConfigurationListResponse
import com.configure_me_meorphis_test_6.api.models.AccountCreditConfigurationPatchAccountCreditConfigurationParams
import com.configure_me_meorphis_test_6.api.models.AccountCreditConfigurationPatchAccountCreditConfigurationResponse
import java.util.concurrent.CompletableFuture

interface CreditConfigurationServiceAsync {

    /** Get an Account's credit configuration */
    @JvmOverloads
    fun list(
        params: AccountCreditConfigurationListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AccountCreditConfigurationListResponse>

    /** Update a Business Accounts credit configuration */
    @JvmOverloads
    fun patchAccountCreditConfiguration(
        params: AccountCreditConfigurationPatchAccountCreditConfigurationParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AccountCreditConfigurationPatchAccountCreditConfigurationResponse>
}
