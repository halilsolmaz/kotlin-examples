package halilsolmaz.app.apps.company

open class Employee(var name: String = "", var citizienId: String = "", var address: String = "") {
    open fun calculateInsurancePayment() : Double = 0.0
}