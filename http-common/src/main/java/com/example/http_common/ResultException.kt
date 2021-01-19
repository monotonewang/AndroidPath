package com.example.http_common


class ResultException(var errCode: String?, var msg: String?) : Exception(msg)
