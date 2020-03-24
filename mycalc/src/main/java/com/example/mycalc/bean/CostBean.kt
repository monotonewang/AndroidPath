package com.example.mycalc.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "costs")
data class CostBean(
        @PrimaryKey(autoGenerate = true)
        var id: Int?,
        var text: String?,
        var datetime: String?
) {
    constructor() : this(null, null, null)
}