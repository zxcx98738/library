<template>
  <div>
    <h2>Login</h2>
    <form @submit.prevent="loginUser">
      <label>Phone Number:</label>
      <input type="text" v-model="phoneNumber" required />
      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      phoneNumber: '',
    };
  },
  methods: {
    loginUser() {
      axios.post('/api/users/login', { phoneNumber: this.phoneNumber })
        .then(response => {
          console.log(response.data);
          // 可在此處進行其他處理，例如跳轉到其他頁面或顯示登入成功訊息
        })
        .catch(error => {
          console.error(error);
          // 可在此處處理錯誤，例如顯示錯誤訊息給使用者
        });
    },
  },
};
</script>