let mongoose = require('mongoose');

let empSchema = mongoose.Schema({
    empName: {
        type: String,
        required: true
    },
    empPass: {
        type: String,
        required: true
    }
});

let Emp = mongoose.model('Emp', empSchema);

module.exports = Emp;