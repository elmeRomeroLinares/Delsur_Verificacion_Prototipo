package com.example.delsurverificacin

class Repository {

    fun getIrregularidadesExternasStringList(): List<String> {
        val irregularidadesExternas = mutableListOf(
            "Acometida", "Medidor", "Inaccesible", "Fraude", "Condición SE", "Otros Riesgos",
            "Lectura Negativa", "Consumo Erróneo", "Otros"
        )

        return irregularidadesExternas
    }

    fun getIrregularidadInternaStringList(): List<String> {
        val irregularidadesInternas = mutableListOf(
            "Instalación Fuera N", "Derivación a tierra", "Equipos Fuera N", "Incremento Carga",
            "Tarifa incorrecta", "Carga sin Relación"
        )

        return irregularidadesInternas
    }

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

    fun getModelosMedidores(): List<String> {
        val modelosMedidoresStringList = mutableListOf(
            "ABB",
            "ABB/D5S",
            "ABB/N8C",
            "CLOU",
            "CLOU/ DDS720",
            "CLOU/DDS719",
            "CLOU/DDS720",
            "DUNCAN",
            "DUNCAN/MF-A",
            "DUNCAN/MKA",
            "DUNCAN/MKS",
            "DUNCAN/MQA",
            "DUNCAN/MQS",
            "EDMI",
            "EDMI/HXE12 (120)",
            "EDMI/IBD1-2",
            "EDMI/IBD1-3",
            "EDMI/LIBRA (214E)",
            "EDMI/MK31E",
            "EDMI/MK31E (120V)",
            "EDMI/MK31E (211)E",
            "ELSTER",
            "ELSTER/A3RLN",
            "ELSTER/ELSTER",
            "FAE",
            "FAE/MF79G",
            "FAE/MF-79G",
            "FAE/MF79GT",
            "FERRANTI",
            "FERRANTI/FMMY",
            "FUJI",
            "FUJI/71WG",
            "FUJI/D-27-G",
            "FUJI/E71DG",
            "FUJI/E-71G",
            "FUJI/E-71G (10A)",
            "FUJI/E71WG",
            "FUJI/FA13",
            "FUJI/FA13E",
            "FUJI/FA23E",
            "FUJI/FA24",
            "FUJI/FA-33",
            "FUJI/FA33E",
            "FUJI/FA34",
            "FUJI/FA34E",
            "FUJI/FD13",
            "FUJI/FD-13-G",
            "FUJI/FD-13-G (216)",
            "FUJI/FD13MG",
            "FULCRUM",
            "FULCRUM/SM4ATR",
            "GALILEO",
            "GALILEO/M5C",
            "GALILEO/MSC4V",
            "GALILEO/N7ES",
            "GENERAL ELECTRIC",
            "GENERAL ELECTRIC/AKI",
            "GENERAL ELECTRIC/AR2",
            "GENERAL ELECTRIC/DM-46",
            "GENERAL ELECTRIC/EV-3",
            "GENERAL ELECTRIC/F85C",
            "GENERAL ELECTRIC/FM-15-A",
            "GENERAL ELECTRIC/I30A",
            "GENERAL ELECTRIC/I-50-A",
            "GENERAL ELECTRIC/I-50-S",
            "GENERAL ELECTRIC/I55A",
            "GENERAL ELECTRIC/I-55S",
            "GENERAL ELECTRIC/I-57A",
            "GENERAL ELECTRIC/I60S",
            "GENERAL ELECTRIC/I-70S",
            "GENERAL ELECTRIC/K2-A",
            "GENERAL ELECTRIC/KV",
            "GENERAL ELECTRIC/V-3-A",
            "GENERAL ELECTRIC/V-62-A",
            "GENERAL ELECTRIC/V-63-A",
            "GENERAL ELECTRIC/V-66-A",
            "GENERAL ELECTRIC/XAG76",
            "GOLDSTAR",
            "GOLDSTAR/WH-13",
            "HENNK",
            "HENNK/IBD1-3",
            "HENNK/LIBRA (212E)",
            "HENNK/POSEIDON (120)",
            "HENNK/POSEIDON (212E)",
            "HENNK/POSEIDON (240)",
            "HEXING",
            "HEXING/HX12D",
            "HEXING/HXE110",
            "HEXING/HXS100",
            "HEXING/LIBRA (214E)",
            "HITACHI ",
            "HITACHI/Y73",
            "HOLLEY",
            "HOLLEY/HLD06",
            "INTECH",
            "INTECH/FF76",
            "INTECH/FORM 2S",
            "INTECH/HX12D",
            "INTECH/HX13D",
            "INTECH/HXE12 (120)",
            "INTECH/HXE12 (240)",
            "INTECH/INTECH HXE34",
            "LANDIS+GYR",
            "LANDIS + GYR/ALTIMUS RXR",
            "LANDIS + GYR/CG51F4",
            "LANDIS + GYR/E650 S4x RXR F12S",
            "LANDIS + GYR/E650 S4x RXR F16S",
            "LANDIS + GYR/E650 S4x RXR F5S",
            "LANDIS + GYR/E650 S4x RXR F9S",
            "LANDIS + GYR/FOCUS F2S",
            "LANDIS + GYR/FOCUS RXR",
            "LANDIS + GYR/FOCUS RXR F12S",
            "LANDIS + GYR/FOCUS RXR F16S",
            "LANDIS + GYR/LIBRA (225AE)",
            "LANDIS + GYR/MAXsys ELITE",
            "LANDIS + GYR/RXR",
            "LANDIS + GYR/RXRS4",
            "LANDIS+GYR/FOCUS RXR",
            "MAPLATEX",
            "MAPLATEX/7AA5935",
            "MITSUBISHI",
            "MITSUBISHI/F34",
            "MITSUBISHI/MDO",
            "MITSUBISHI/MF33",
            "MITSUBISHI/MF-63",
            "MITSUBISHI/MF64",
            "MITSUBISHI/MU-80G",
            "NANSEN",
            "NANSEN/M1A",
            "NANSEN/M1A-G",
            "NANSEN/M1A-T",
            "NANSEN/M2A",
            "NANSEN/M2A-G",
            "NANSEN/MC",
            "NANSEN/PN5B",
            "NEXUS",
            "NEXUS/1272",
            "NEXUS/SHARK 270",
            "OSAKI ELECTRIC",
            "OSAKI ELECTRIC/OB09",
            "OSAKI ELECTRIC/OW09G",
            "PRECISION",
            "PRECISION/S3P2",
            "PRECISION/XG121",
            "PRECISION/XG-132",
            "SANGAMO",
            "SANGAMO/ACL",
            "SANGAMO/C2S",
            "SANGAMO/C2WA",
            "SANGAMO/C2X",
            "SANGAMO/CJ3A",
            "SANGAMO/CJA",
            "SANGAMO/CWA",
            "SANGAMO/CYA",
            "SANGAMO/CYL",
            "SANGAMO/CYLP (120)",
            "SANGAMO/CYLP (240)",
            "SANGAMO/CYLP (CL20)",
            "SANGAMO/CYLS",
            "SANGAMO/CYS",
            "SANGAMO/CYWA",
            "SANGAMO/CYWA 200A",
            "SANGAMO/CYWP",
            "SANGAMO/CYWP (120)",
            "SANGAMO/CYWP (240)",
            "SANGAMO/J2A",
            "SANGAMO/J2J",
            "SANGAMO/J2S",
            "SANGAMO/J3S",
            "SANGAMO/J5DS",
            "SANGAMO/JA",
            "SANGAMO/M-2S",
            "SANGAMO/NBAP",
            "SANGAMO/NBDP",
            "SANGAMO/S3",
            "SANGAMO/S3 (T200A)",
            "SANGAMO/S3B",
            "SANGAMO/SL6DS",
            "SANGAMO/SL6S",
            "SANGAMO/TJA",
            "SCHLUMBERGER",
            "SCHLUMBERGER/FX221",
            "SCHLUMBERGER/SL6A",
            "SCHLUMBERGER/SM6ATR",
            "SCHLUMBERGER/SV4AR",
            "SIEMENS",
            "SIEMENS/LIBRA",
            "SIEMENS/LIBRA (114E)",
            "SIEMENS/LIBRA (212E)",
            "SIEMENS/LIBRA (214E)",
            "SIEMENS/LIBRA (225AE)",
            "SIEMENS/LIBRA (233E)",
            "SIEMENS/RXRS4 (114E)",
            "SIEMENS/RXRS4 200A (233E)",
            "SIEMENS/RXS4",
            "STAR INSTRUMENT",
            "STAR INSTRUMENT/DDS26E",
            "SYMTEX",
            "SYMTEX/EM88",
            "TOSHIBA",
            "TOSHIBA/I15D",
            "VECTRON",
            "VECTRON/SV4AR",
            "VOLTREX",
            "VOLTREX/DD955-72",
            "VOLTREX/DD955-73",
            "VOLTREX/IBD1-3",
            "WESTINGHOUSE",
            "WESTINGHOUSE/CA",
            "WESTINGHOUSE/D3S",
            "WESTINGHOUSE/D5S",
            "WESTINGHOUSE/EO",
            "WESTINGHOUSE/OB",
            "OTRO")

        return modelosMedidoresStringList.toList()

    }
}

