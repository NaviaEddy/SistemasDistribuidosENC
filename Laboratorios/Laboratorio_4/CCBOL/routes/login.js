const express = require('express');
const path = require('path');
const router = express.Router();
const loginController = require('../controllers/loginController');
router.use(express.static(path.join(__dirname,'public')));



router.get('/', loginController.view);
router.post('/', loginController.send);



module.exports = router;