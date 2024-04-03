package halilsolmaz.app.apps.company

open class Manager (name: String = "", citizienId: String = "", address: String = "",
                    var department: String = "", var salary: Double = 0.0 ) : Employee(name, citizienId, address) {
    override fun calculateInsurancePayment() = salary * 1.5
}