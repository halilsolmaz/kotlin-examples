package halilsolmaz.app.apps.company

open class Worker (name: String = "", citizienId: String = "", address: String = "",
                   var feePerHour: Double = 0.0, var hourPerDay:Int = 0 ) : Employee(name, citizienId, address) {

    override fun calculateInsurancePayment() = feePerHour * hourPerDay * 30
}