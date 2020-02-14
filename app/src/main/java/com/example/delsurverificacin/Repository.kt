package com.example.delsurverificacin

class Repository {

    fun getTarifasStringList(): List<String> {
        val tarifasStringArray = mutableListOf(
            "E_1G", "E_GMH", "E_MBP", "E_MMH", "E_MMP", "G_1AP", "G_1G", "G_1GC", "G_GBH",
            "G_GM2", "G_GMH", "G_MB1", "G_MBH", "G_MBP", "G_MM1", "G_MMH", "G_MMP", "R_1R",
            "R_1RC", "T_1G", "T_MBH", "T_MBP"
        )

        return tarifasStringArray.toList()
    }

    fun getMarcaMedidorStringList(): List<String> {
        val marcaMedidorStringList = mutableListOf(
            "ABB", "CLOU", "DUNCAN", "EDMI", "ELSTER", "FAE", "FERRANTI", "FUJI", "FULCRUM",
            "GALILEO", "GENERAL ELECTRIC", "GOLDSTAR", "HENNK", "HEXING", "HITACHI ", "HOLLEY",
            "INTECH", "LANDIS+GYR", "MAPLATEX", "MITSUBISHI", "NANSEN", "NEXUS", "OSAKI ELECTRIC",
            "PRECISION", "SANGAMO", "SCHLUMBERGER", "SIEMENS", "STAR INSTRUMENT", "SYMTEX",
            "TOSHIBA",  "VECTRON",  "VOLTREX",  "WESTINGHOUSE", "OTRO"
            )

        return marcaMedidorStringList.toList()
    }

    fun getModeloMedidorABBStringList(): List<String> {
        val modeloMedidorABBStringList = mutableListOf("ABB/D5S", "ABB/N8C")
        return modeloMedidorABBStringList
    }

    fun getModeloMedidorCLOUStringList(): List<String> {
        val modeloMedidorCLOUStringList = mutableListOf("CLOU/ DDS720", "CLOU/DDS719",
            "CLOU/DDS720")
        return modeloMedidorCLOUStringList
    }

    fun getModeloMedidorDUNCANStringList(): List<String> {
        val modeloMedidorDUNCANStringList = mutableListOf("DUNCAN/MF-A", "DUNCAN/MKA",
            "DUNCAN/MKS", "DUNCAN/MQA", "DUNCAN/MQS")
        return modeloMedidorDUNCANStringList
    }
}

