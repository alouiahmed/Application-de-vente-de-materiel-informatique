const mongoose= require('mongoose');
const Scheme= mongoose.Schema;

const ReclamationSchema = new Scheme({
    object: { 
        type: String, 
        required: false 
    },
    description: {
        type: String,
        required: true
    },
    idProduct: {
        type: Number,
        required: true
    },
    idUser: {
        type: Number,
        required: true
    },
    dateRec: {
        type: Date,
        default: Date.now
    },
    etat: { 
        type: String, 
        default: "Pending",
        enum: ['Treated', 'Pending']
    },
    type: { 
        type: String, 
        required: true, 
        enum: ['Problem', 'Suggestion','other...'] 
    },
    archived: { 
        type: Boolean, 
        default: false
    }
 

});
module.exports = Post=mongoose.model('reclamation',ReclamationSchema);