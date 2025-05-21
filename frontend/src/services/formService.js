import axios from 'axios'

export default {
  async readAll() {
    console.log('service readAll() 실행')
    const res = await axios.get('/v1/api/forms')
    return res.data
  },
}
