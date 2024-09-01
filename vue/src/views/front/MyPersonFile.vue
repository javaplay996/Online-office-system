<template>
  <el-card style="width: 500px; margin: 10px auto">
    <el-form label-width="80px" size="small" v-if = "form  != null">
      <el-form-item label="照片">
      <el-upload
          class="avatar-uploader"
          :action="'http://localhost:9090/file/upload'"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
      >
        <img v-if="form.avatarUrl" :src="form.avatarUrl" class="avatar">
        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-upload>
      </el-form-item>
      <el-form-item label="用户名">
        <el-input v-model="form.name" disabled autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="员工编号">
        <el-input v-model="form.number" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="工资">
        <el-input v-model="form.salary" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="身份证">
        <el-input v-model="form.idcard" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="入职日期">
        <el-input v-model="form.hiretime" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div v-if = "form  == null">
      你还没有人事档案信息，请联系管理员增加
    </div>
  </el-card>
</template>

<script>

export default {
  name: "MyPersonFile",
  data() {
    return {
      form: null,
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    }
  },
  created() {
    this.getUser().then(res => {
      console.log(res)
      this.form = res
    })
  },
  methods: {
    async getUser() {
      return (await this.request.get("/personfile/getByUserId/" + this.user.id)).data
    },
    save() {
      this.request.post("/user", this.form).then(res => {
        if (res.code === '200') {
          this.$message.success("保存成功")

          // 触发父级更新User的方法
          this.$emit("refreshUser")

          // 更新浏览器存储的用户信息
          this.getUser().then(res => {
            res.token = JSON.parse(localStorage.getItem("user")).token
            localStorage.setItem("user", JSON.stringify(res))
          })

        } else {
          this.$message.error("保存失败")
        }
      })
    },
    handleAvatarSuccess(res) {
      this.form.avatarUrl = res
    }
  }
}
</script>

<style>
.avatar-uploader {
  text-align: center;
  padding-bottom: 10px;
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 138px;
  height: 138px;
  line-height: 138px;
  text-align: center;
}
.avatar {
  width: 138px;
  height: 138px;
  display: block;
}
</style>
