package com.ozcanalasalvar.datepicker.utils

import com.ozcanalasalvar.datepicker.model.Date


fun Date.monthsOfDate(startDate: Date, endDate: Date): List<Int> {
    val months = mutableListOf<Int>()
//    if (this.year == startDate.year) {
//        for (month in startDate.month..11) {
//            months.add(month)
//        }
//    } else if (this.year == endDate.year) {
//        for (month in 0..endDate.month) {
//            months.add(month)
//        }
//    } else {
        for (month in 0..11) {
            months.add(month)
        }
//    }

    return months
}


fun Date.daysOfDate(startDate: Date, endDate: Date): List<Int> {
    val days = mutableListOf<Int>()
    val monthDayCount = DateUtils.getMonthDayCount(this.date)
//
//    if (this.year == startDate.year && this.month == startDate.month && startDate.day != 1) {
//        for (day in startDate.day..monthDayCount) {
//            days.add(day)
//        }
//    } else if (this.year == endDate.year && this.month == endDate.month && endDate.day != monthDayCount) {
//        for (day in 1..endDate.day) {
//            days.add(day)
//        }
//    } else {
        for (day in 1..monthDayCount) {
            days.add(day)
        }
//    }

    return days
}


fun Date.isFullMonthOfYear(minDate: Date, maxDate: Date): Boolean =
    !((this.year == minDate.year && minDate.month != 11) || (this.year == maxDate.year && maxDate.month != 0))

fun Date.isFullDayOfMonth(minDate: Date, maxDate: Date): Boolean {
    val monthDayCount = DateUtils.getMonthDayCount(this.date)
    val isMin =
        (this.year == minDate.year && this.month == minDate.month && minDate.day != 1)
    val isMax =
        (this.year == maxDate.year && this.month == maxDate.month && maxDate.day != monthDayCount)
    return !(isMin || isMax)
}

fun Date.withYear(year: Int): Date {
    return Date(year, this.month, this.day)
}

fun Date.withMonth(month: Int): Date {
    return Date(this.year, month, this.day)
}

fun Date.withDay(day: Int): Date {
    return Date(this.year, this.month, day)
}
