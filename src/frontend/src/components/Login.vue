<template>
     <div class="card card-container shadow-none">
     
     <h1> Jeux des cartes </h1>
 
       <div class="box rounded-box shadow-2 form-type-material position-relative">
       <Form @submit="validateBeforeSubmit" :validation-schema="schema"  v-slot="{ errors }">
 
         <!--  show username -->
         <div class="form-group mb-2 flexbox">
           <div class=" w-100">          
             <Field name="username" type="text" class="form-control w-100" :class="{ 'is-invalid': errors.username }" required v-model="username"/> 
             <label class="required" for="username">Nom d'utilisateur</label>
             <ErrorMessage name="username" class="invalid-feedback" />
         </div>
         </div>
 
         <!-- password -->
           <div class="form-group mb-2 flexbox">
             <div class=" w-106">
                 <Field name="password" :type="`${type}`"
               class="form-control w-106" :class="{ 'is-invalid': errors.password }" required v-model="password"/>
               <label class="required" for="password">Mot de passe</label>
               <ErrorMessage name="password" class="invalid-feedback" />
             </div>
              <!-- show and hide password -->
              <span :class="type == 'text' ? 'mdi mdi-eye-outline fs-20 cursor-pointer' : 'mdi mdi-eye-off-outline fs-20 cursor-pointer'" @click="showPassword()"></span>
           </div>
 
 
         <div v-if="error" class="invalid-feedback d-block">
            Nom d'utilisateur ou mot de passe incorrecte
         </div>
 
         <!-- submit -->
         <div class="text-center" >
           <button class="btn btn-round btn-custom">
             <span>Se connecter</span>
           </button>
         </div>
 
         </Form>
       </div>
     </div>
 

</template>

<script>

import router from '../router/routes.js'
import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";

export default {

  name: 'Login',

  components: {
      Form,
      Field,
      ErrorMessage
  },

  data () {
    const schema = yup.object().shape({
      username : yup.string().required("nom d'utilisateur est obligatoire"),
      password: yup.string().required("Le mot de passe est obligatoire")
    });
    return {
      username: "",
      password: "",
      error: false,
      schema,
      type:"password"   
      
    }
  },

  mounted() {
    fetch("/api/credentials")
      .then(async (response ) => {
        if (response.ok) {
        const result = await response.json();
        if(localStorage.getItem('user-username') === result.username && localStorage.getItem('user-password') === result.password){
          this.error = false
          router.push('/game').catch(()=>{});
         }
        }
    
      });
  },

  methods: {

    validateBeforeSubmit () {
      if(this.username && this.password){
        
        const requestOptions = {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({ "username": this.username, "password": this.password })
        };

        fetch("/api/login",requestOptions).then(async (response ) => {
          console.log("response ==> ", response.text);
            if (response.ok) {
                this.error = false
                localStorage.setItem('user-username', this.username)
                localStorage.setItem('user-password', this.password)
                router.push('/game').catch(()=>{}); 
            } else {
              this.error = true
            }
        });
      }
    },

    showPassword(){
      if(this.type == "password"){
        this.type = "text";
      }
      else if( this.type == "text"){
        this.type = "password";
      }
    }
    
  }
}
</script>