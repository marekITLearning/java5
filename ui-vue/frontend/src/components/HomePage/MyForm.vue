<template>
  <form>
    <input type="text" v-model="first"><br>
    <input type="text" v-model="last"><br>
    <input type="text" v-model="status"><br>
    <v-btn @click.prevent="save">Save</v-btn>
  </form>
</template>

<script>
export default {
  name: 'MyForm',

  data () {
    return {
      first: '',
      last: '',
      status: ''
    }
  },

  methods: {
    save () {
      this.$api
        .post('/customer')
        .set('Content-Type', 'application/json')
        .send({
          firstName: this.first,
          lastName: this.last,
          status: this.status
        })
        .then(response => {
          this.$emit('updateCustomers')
        })
    }
  }
}
</script>
