package com.thejan.assessment.androidtest.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thejan.assessment.androidtest.utils.SHARED_PREF_KEY_INPUT
import com.thejan.assessment.androidtest.viewmodel.base.ViewModelState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import android.content.Context.MODE_PRIVATE




@HiltViewModel
class MainViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    internal val state: MutableLiveData<ViewModelState>
) : ViewModel() {

    fun saveData(text: String) {
        if (text.isNullOrEmpty()) {
            state.postValue(ViewModelState.invalid())
        } else {
            val editor = sharedPreferences.edit()
            editor.putString(SHARED_PREF_KEY_INPUT, text)
            editor.apply()
            state.postValue(ViewModelState.saved())
        }
    }

    fun getSavedValue(): String {
        return sharedPreferences.getString(SHARED_PREF_KEY_INPUT, "")!!
    }
}