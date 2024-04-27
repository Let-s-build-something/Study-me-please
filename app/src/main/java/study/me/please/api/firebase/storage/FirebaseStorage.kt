package study.me.please.api.firebase.storage

object FirebaseStorage {

    sealed class Reference {

        companion object {
            private const val BASE_URL = "gs://study-me-please.appspot.com"
        }

        open val locationPath: String
            get() = BASE_URL

        /** returns a storage reference */
        /*val storageReference: com.google.firebase.storage.StorageReference
            get() = Firebase.storage.getReferenceFromUrl(this.locationPath)*/

        sealed class Resources: Reference() {

            override val locationPath: String
                get() = super.locationPath + "/resources"
        }
    }
}