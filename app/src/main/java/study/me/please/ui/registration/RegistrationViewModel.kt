package study.me.please.ui.registration

import dagger.hilt.android.lifecycle.HiltViewModel
import study.me.please.base.BaseViewModel
import javax.inject.Inject

/** Communication bridge between UI and DB */
@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val repository: RegistrationRepository
): BaseViewModel() {

}