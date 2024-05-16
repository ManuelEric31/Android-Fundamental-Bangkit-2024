package com.dicoding.myunittest

import android.health.connect.datatypes.units.Length

class CuboidModel {
    private var length = 0.0
    private var width = 0.0
    private var height = 0.0

    fun getVolume() : Double = width * length * height

    fun getSurfaceArea(): Double {
        val wl = width * length
        val wh = width * height
        val lh = length * height
        return 2 * (wl + wh + lh)
    }

    fun getCircumference() : Double = (length+width+height) * 4

    fun save(length: Double, width: Double, height: Double) {
        this.length = length
        this.width = width
        this.height = height
    }
}