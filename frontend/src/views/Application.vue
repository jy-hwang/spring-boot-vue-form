<template>
  <div class="application">
    <div class="top">
      <span class="title">{{ state.form.title }}</span>
      <span class="desc"> : {{ state.form.description }}</span>
    </div>
    <form @submit.prevent="submit">
      <div class="mb-4 row">
        <label for="writerName" class="col-sm-4 col-form-label">작성자명</label>
        <div class="col-sm-8">
          <input
            type="text"
            class="form-control"
            id="writerName"
            v-model="state.inputs.writerName"
            required
          />
        </div>
      </div>

      <div class="mb-4 row">
        <label for="ageRange" class="col-sm-4 col-form-label">연령대</label>
        <div class="col-sm-8">
          <select
            id="ageRange"
            class="form-select"
            aria-label="Default select example"
            v-model="state.inputs.ageRange"
          >
            <option selected>선택하세요</option>
            <option :value="10">10대이해(~19)</option>
            <option :value="20">20대(20~29)</option>
            <option :value="30">30대(30~39)</option>
            <option :value="40">40대(40~49)</option>
            <option :value="50">50대(50~59)</option>
            <option :value="60">60대(60~69)</option>
            <option :value="70">70대(70~79)</option>
            <option :value="80">80대이상(80~)</option>
          </select>
        </div>
      </div>

      <div class="mb-4 row">
        <label for="ageRange" class="col-sm-4 col-form-label">성별</label>
        <div class="col-sm-8 d-flex justify-content-center">
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              name="gender"
              id="genderMale"
              value="M"
              v-model="state.inputs.gender"
            />
            <label class="form-check-label" for="genderMale">남</label>
          </div>
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              name="gender"
              id="genderFemale"
              value="F"
              v-model="state.inputs.gender"
            />
            <label class="form-check-label" for="genderFemale">여</label>
          </div>
        </div>
      </div>

      <div class="mb-4 row">
        <label for="content" class="col-sm-4 col-form-label">내용</label>
        <div class="col-sm-8">
          <textarea
            class="form-control"
            name="content"
            id="content"
            rows="10"
            cols="40"
            v-model="state.inputs.content"
            required
          ></textarea>
        </div>
      </div>
      <div class="d-flex justify-content-center">
        <button type="submit" class="btn btn-primary w-25">제출</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import applicationService from '@/services/applicationService'
import formService from '@/services/formService'
import { reactive } from 'vue'
import { useRoute, useRouter } from 'vue-router'

function emptyAndFocus(elementId) {
  const el = document.getElementById(elementId)
  if (el) {
    el.value = ''
    el.focus()
  }
}

const state = reactive({
  form: {
    id: 0,
    title: '',
    description: '',
    createdAt: '',
  },
  inputs: {
    parentFormId: 0,
    writerName: '',
    ageRange: '30',
    gender: 'M',
  },
})

const router = useRouter()

const submit = async () => {
  if (!state.inputs.writerName.trim()) {
    window.alert('작성자명을 입력해주세요')
    emptyAndFocus('writerName')
    return
  }

  if (!state.inputs.content.trim()) {
    window.alert('내용을 입력해주세요')
    emptyAndFocus('content')
    return
  }

  const output = await applicationService.save(state.inputs)

  if (output) {
    window.alert('신청서 제출을 완료했습니다.')
    router.push('/')
    return
  }

  window.alert('오류가 있습니다.')
}

const route = useRoute()

;(async () => {
  const id = route.params.id
  state.form = await formService.readOne(id)
  state.inputs.parentFormId = id
})()
</script>

<style lang="scss" scoped>
.application {
  .top {
    margin-bottom: 30px;
    border-bottom: 15px solid #ddd;
    .title {
      font-weight: 600;
    }
  }
}
</style>
