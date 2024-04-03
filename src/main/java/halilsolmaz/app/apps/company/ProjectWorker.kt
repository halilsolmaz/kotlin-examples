package halilsolmaz.app.apps.company

open class ProjectWorker (name: String = "", citizienId: String = "", address: String = "",
                          feePerHour: Double = 0.0, hourPerDay:Int = 0, val extraFee: Double = 0.0 ) : Worker(name, citizienId, address, feePerHour, hourPerDay) {

    override fun calculateInsurancePayment() = super.calculateInsurancePayment() + extraFee
}