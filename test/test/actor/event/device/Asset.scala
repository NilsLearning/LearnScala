package test.actor.event.device

/**
 * 资产积分对象
 * @param operation 操作 add增加资产 delete删除资产
 * @param param 资产参数（user，hierarchyId）等信息
 */
case class Asset(operation: String, param: Map[String, String])
