package com.example.delsurverificacin

class Repository() {

    fun getTarifasStringArray(): List<String> {
        val tarifasStringArray = mutableListOf<String> (
            "E_1G", "E_GMH", "E_MBP", "E_MMH", "E_MMP", "G_1AP", "G_1G", "G_1GC", "G_GBH",
            "G_GM2", "G_GMH", "G_MB1", "G_MBH", "G_MBP", "G_MM1", "G_MMH", "G_MMP", "R_1R",
            "R_1RC", "T_1G", "T_MBH", "T_MBP")

        return tarifasStringArray.toList()
    }
}