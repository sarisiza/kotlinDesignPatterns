package classicalPatterns.creationalPatterns

data class User(
    val name: String,
    val role: Role,
    private val permissions: Set<String>,
    val tasks: List<String>
) {
    val allUsers = mutableListOf<User>()
    fun hasPermission(permission: String) = permission in permissions

    fun createUser(_name: String, role: Role) {
        for (u in allUsers) {
            if (u.role == role) {
                //without prototype
                //allUsers += User(name, role, u.permissions, u.tasks)
                //with prototype
                allUsers += u.copy(name = _name)
                return
            } else {
                allUsers += User(_name, role, mutableSetOf(), mutableListOf())
            }
        }
    }
}

enum class Role {
    ADMIN,
    SUPER_ADMIN,
    REGULAR_USER
}