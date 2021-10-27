const express = require('express');
const router = express.Router();
const {check, validationResult}= require('express-validator/check');
const Reclamation = require('../../models/Reclamation');
//@route Post api/reclamation
//@desc Create reclamation
//@access Private
router.post(
    '/',
    [
       
        check('description', 'Description is required').not().isEmpty(),
        check('idProduct', 'Choose product to save your reclamation').not().isEmpty(),
        check('idUser', 'You must do login').not().isEmpty(),
        check('type', 'Choose the type of reclamation').not().isEmpty(),
        
    ],
async(req,res)=>{
    const errors= validationResult(req);
    if(!errors.isEmpty()){
        return res.status(400).json({errors: errors.array()});
    }
    try{
    //créer un nouveau reclamation
    const newReclamation= new Reclamation({
        description: req.body.description,
        object: req.body.object,
        type: req.body.type,
        idProduct: req.body.idProduct,
        idUser: req.body.idUser
    });
    //save
    await newReclamation.save();
    }
    catch(err){
        console.error(err.message);
        res.status(500).send('Server Error');
    }    
});
//@route Get api/reclamations
//@desc GET ALL Reclamations
//@access Private
router.get('/',
async(req,res)=> {
    try{
        const listReclamations= await Reclamation.find().sort({dateRec: -1});
        return res.json(listReclamations);
    }
    catch(err){
        console.error(err.message);
        res.status(500).send('Server Error');
    }
}
);
//@route Reclamation api/reclamations/:id
//@desc get reclamation par id
//@access Private 
router.get('/:id',
async(req,res)=>{
    try{
        const reclamation= await Reclamation.findById(req.params.id);
        if(!reclamation){
           return res.status(404).json({msg: 'Reclamation not found'});
        }     
        res.json(reclamation);   
    }
    catch(err){
        console.error(err.message);
        if(err.kind === 'ObjectId'){ //it's not a valid objectId
            return res.status(404).json({msg: 'Reclamation not found'});
         }
        res.status(500).send('Server Error');   
    }
});

//@route Reclamation api/reclamattions/:id
//@desc delete reclamation
//@access Private
router.delete('/:id',
async(req,res)=>{
    try{
        const reclamationDelete= await Reclamation.findById(req.params.id);
        //check if the reclamation exist
        if(!reclamationDelete){
           return res.status(404).json({msg: 'Reclamation not found'});
        }     
        await reclamationDelete.deleteOne();
    res.status(200).send('Deleted successfully');   

    }
    catch(err){
        console.error(err.message);
        if(err.kind === 'ObjectId'){ //it's not a valid objectId
            return res.status(404).json({msg: 'Reclamation not found'});
         }
        res.status(500).send('Server Error');   
    }
});
//@route Put api/Reclamation/archived/:id
//@desc arc
//@access Private
router.put('/archived/:id',
async(req,res)=>{
    try{
        const rec= await Reclamation.findById(req.params.id);

        rec.archived = true;
         await rec.save();
         return res.status(200).json({msg: 'Reclamation archived !!'});
    }
    catch(err){
        console.error(err.message);
        if(err.kind === 'ObjectId'){ //it's not a valid objectId
            return res.status(404).json({msg: 'Reclamation not found'});
         }
        res.status(500).send('Server Error');   
    }
});
//@route Put api/Reclamation/state/:id
//@desc arc
//@access Private
router.put('/state/:id',
async(req,res)=>{
    try{
        const rec= await Reclamation.findById(req.params.id);

        rec.etat = "Treated";
         await rec.save();
         return res.status(200).json({msg: 'Reclamation Treated !!'});
    }
    catch(err){
        console.error(err.message);
        if(err.kind === 'ObjectId'){ //it's not a valid objectId
            return res.status(404).json({msg: 'Reclamation not found'});
         }
        res.status(500).send('Server Error');   
    }
});
module.exports = router;
