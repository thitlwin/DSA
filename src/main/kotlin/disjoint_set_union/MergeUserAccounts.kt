package disjoint_set_union

data class UserEmailPair(val user: String, val email: String) : Comparable<UserEmailPair> {
    override fun compareTo(other: UserEmailPair): Int {
        if (user != other.user)
            return user.compareTo(other.user)
        return email.compareTo(other.email)
    }
}

fun mergeAccounts(accounts: List<List<String>>): List<List<String>> {
    val unionFind = UnionFind<UserEmailPair>()
    val allUserEmails = HashSet<UserEmailPair>();
    for (acc in accounts) { // creating user email pair O(n)
        val userName = acc[0]
        var emailParent: UserEmailPair? = null
        for (i in 1 until acc.size) {
            val email = acc[i]
            val userEmailPair = UserEmailPair(userName, email)
            allUserEmails.add(userEmailPair)
            if (emailParent == null)
                emailParent = userEmailPair
            else
                unionFind.union(emailParent, userEmailPair)
        }
    }

    val accountAssociation = HashMap<UserEmailPair, ArrayList<UserEmailPair>>()
    for (userEmailPair in allUserEmails) {
        val ancestor = unionFind.find(userEmailPair)
        if (!accountAssociation.containsKey(ancestor)) {
            accountAssociation[ancestor] = ArrayList()
        }
        accountAssociation[ancestor]?.add(userEmailPair)
    }

    val returnRes = ArrayList<List<String>>() // SC => O(n)
    for (userInfo in accountAssociation.entries) {
        val oneUser = ArrayList<String>()
        oneUser.add(userInfo.key.user)
        userInfo.value.sort()
        for (emailEntry in userInfo.value) {
            oneUser.add(emailEntry.email)
        }
        returnRes.add(oneUser)
    }

    returnRes.sortWith(
        Comparator { a, b ->
            if (a[0].compareTo(b[0]) == 0)
                a[1].compareTo(b[1])
            else
                a[0].compareTo(b[0])
        }
    )
    return returnRes
}

fun main() {
    val list1 = listOf(
        listOf("James", "johnson@fastmail.com", "jamesj@company.com", "mrswashyhat@funmail.com"),
        listOf("Jimmy", "johnson@fastmail.com", "jimmyj@company.com"),
        listOf("Jimmy", "beastboi@funmail.com", "jimmyj@company.com"),
        listOf("Owen", "ojohnson@fastmail.com", "owenj2@biggov.ca"),
        listOf("Owen", "owenj2@biggov.ca", "owen_johnson@funmail.com"),
        listOf("Jimmy", "beastboi@funmail.com", "beastboi2@funmail.com")
    )
    val res = mergeAccounts(list1)
    res.forEach {
        println(it)
    }
}