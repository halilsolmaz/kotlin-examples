package halilsolmaz.app.apps.company

abstract class Employee(var name: String = "", var citizienId: String = "", var address: String = "") {
    abstract fun calculateInsurancePayment() : Double
}