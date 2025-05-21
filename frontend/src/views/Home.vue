<script setup>
import formService from '@/services/formService'

import { reactive } from 'vue'

const state = reactive({
  forms: [],
})

;(async () => {
  state.forms = await formService.readAll()
})()


function formatDate(dateStr) {
  return dayjs(dateStr).tz('Asia/Seoul').format('YYYY-MM-DD HH:mm:ss')
}
</script>

<template>
  <div class="home">
    <ul>
      <li v-for="f in state.forms" :key="f.id">
        <router-link :to="`/forms/${f.id}`">
          <div class="title">{{ f.title }}</div>
          <div class="desc">{{ f.description }}</div>
          <div class="date">
            생성일시 :
            {{ f.createdAt }}
          </div>
        </router-link>
      </li>
    </ul>
  </div>
</template>

<style lang="scss" scoped>
.home {
  ul {
    list-style: none;
    margin: 0;
    padding: 0;

    li {
      margin: 0;
      padding: 0;
      border: 1px solid #eee;

      a {
        display: block;
        padding: 15px;
        text-decoration: none;
        color: inherit;

        &:hover {
          background-color: #eee;
        }

        .title {
          font-weight: bold;
        }
      }
    }
  }
}
</style>
