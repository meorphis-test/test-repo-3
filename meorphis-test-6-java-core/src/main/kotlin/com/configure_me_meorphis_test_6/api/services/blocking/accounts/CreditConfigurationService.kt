// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.configure_me_meorphis_test_6.api.services.blocking.accounts

import com.configure_me_meorphis_test_6.api.core.RequestOptions
import com.configure_me_meorphis_test_6.api.models.AccountCreditConfigurationListParams
import com.configure_me_meorphis_test_6.api.models.AccountCreditConfigurationListResponse
import com.configure_me_meorphis_test_6.api.models.AccountCreditConfigurationPatchAccountCreditConfigurationParams
import com.configure_me_meorphis_test_6.api.models.AccountCreditConfigurationPatchAccountCreditConfigurationResponse

interface CreditConfigurationService {

    /** Get an Account's credit configuration */
    @JvmOverloads
    fun list(
        params: AccountCreditConfigurationListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountCreditConfigurationListResponse

    /** Update a Business Accounts credit configuration */
    @JvmOverloads
    fun patchAccountCreditConfiguration(
        params: AccountCreditConfigurationPatchAccountCreditConfigurationParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountCreditConfigurationPatchAccountCreditConfigurationResponse
}
