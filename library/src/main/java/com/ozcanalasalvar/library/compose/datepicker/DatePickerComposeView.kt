package com.ozcanalasalvar.library.compose.datepicker


import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ozcanalasalvar.library.model.DateModel
import com.ozcanalasalvar.library.utils.DateUtils
import com.ozcanalasalvar.library.view.datepicker.DatePicker

class DatePickerComposeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : AbstractComposeView(context, attrs, defStyle) {


    private val offsetState = mutableStateOf(4)
    private val yearsRangeState = mutableStateOf(IntRange(1923, 2121))
    private val startDateState = mutableStateOf(DateModel(DateUtils.getCurrentTime()))
    private val selectorEffectEnabledState = mutableStateOf(true)
    private val textSizeState = mutableStateOf(17)
    var offset: Int
        get() = offsetState.value
        set(value) {
            offsetState.value = value
        }

    var yearsRange: IntRange
        get() = yearsRangeState.value
        set(value) {
            yearsRangeState.value = value
        }

    var startDate: DateModel
        get() = startDateState.value
        set(value) {
            startDateState.value = value
        }

    var selectorEffectEnabled: Boolean
        get() = selectorEffectEnabledState.value
        set(value) {
            selectorEffectEnabledState.value = value
        }

    var textSize: Int
        get() = textSizeState.value
        set(value) {
            textSizeState.value = value
        }

    private var dataSelectListener: DatePicker.DataSelectListener? = null
    fun setDataSelectListener(dataSelectListener: DatePicker.DataSelectListener?) {
        this.dataSelectListener = dataSelectListener
    }

    @Suppress("RedundantVisibilityModifier")
    protected override var shouldCreateCompositionOnAttachedToWindow: Boolean = false
        private set

    @Composable
    override fun Content() {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        WheelDatePicker(offset = offsetState.value,
            yearsRange = yearsRangeState.value,
            startDate = startDateState.value,
            selectorEffectEnabled = selectorEffectEnabledState.value,
            textSize= textSizeState.value,
            onDateSelected = { day, month, year, date ->
                dataSelectListener?.onDateSelected(date, day, month, year)
            })
    }


    override fun getAccessibilityClassName(): CharSequence {
        return javaClass.name
    }

}