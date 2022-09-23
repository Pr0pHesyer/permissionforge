package com.example.permissionforge_ng.viewModel

import androidx.lifecycle.ViewModel
import java.util.*

class ApplicantViewModel: ViewModel() {
    private lateinit var _applicantName: String
    val applicantName: String
        get() = _applicantName

    private lateinit var _counselorName: String
    val counselorName: String
        get() = _counselorName

    private var _time: Int = 0
    val time: Int
    get() = _time

    private lateinit var _school: String
    val school: String
        get() = _school

    private lateinit var _reason: String
    val reason: String
        get() = _reason

    private lateinit var _dst: String
    val dst: String
        get() = _dst

    private lateinit var _startTimeStr: String
    val startTimeStr: String
    get() = _startTimeStr

    private lateinit var _endTimeStr: String
    val endTimeStr: String
    get() = _endTimeStr

    private lateinit var _tel: String
    val tel: String
        get() = _tel

    private lateinit var _home: String
    val home: String
        get() = _home

    fun setApplicant(
        applicantName: String,
        counselorName: String,
        time: Int,
        school: String,
        reason: String,
        dst: String,
        home: String
    ){
        _applicantName = applicantName
        _counselorName = counselorName
        _time = time!!
        _school = school
        _reason = reason
        _dst = dst
        _home = home

        val startTime = Calendar.getInstance()
        val endTime = Calendar.getInstance()
        endTime.add(Calendar.HOUR,time)
        _startTimeStr =  "${startTime.get(Calendar.MONTH)+1}-${startTime.get(Calendar.DAY_OF_MONTH)} ${startTime.get(Calendar.HOUR_OF_DAY)}:00"
        _endTimeStr = "${endTime.get(Calendar.MONTH)+1}-${endTime.get(Calendar.DAY_OF_MONTH)} ${endTime.get(Calendar.HOUR_OF_DAY)}:00"
        _tel = "18${randd()}${randd()}${randd()}${randd()}${randd()}${randd()}${randd()}${randd()}${randd()}"
    }

    //用于生成电话号码
    private fun randd() : Int{
        return (0..9).random()
    }
}