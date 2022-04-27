package com.thejan.assessment.androidtest.di

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.thejan.assessment.androidtest.viewmodel.base.ViewModelState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("shared_pref_test", Context.MODE_PRIVATE)
    }

    @Provides
    fun state(): MutableLiveData<ViewModelState> {
        return MutableLiveData()
    }
}