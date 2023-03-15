package hu.kirdev.board.model

data class BoardMessage(

    // java: final int id;
    val id: Int,

    val name: String,

    val message: String,

    val timestamp: Long,

)