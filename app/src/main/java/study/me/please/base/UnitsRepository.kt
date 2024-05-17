package study.me.please.base

import study.me.please.data.room.FactDao
import study.me.please.data.room.UnitDao
import javax.inject.Inject

/** Proxy for calling network and local DB end points */
class GeneralClipBoardRepository @Inject constructor(
    private val factDao: FactDao,
    private val unitDao: UnitDao
) {


}