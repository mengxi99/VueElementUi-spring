<template>
    <div>
        <div>
            <el-container style="height: 500px; border: 1px solid #eee">
                <el-header style="font-size:40px;background-color:rgb(172, 150, 150)">tlias笑傲江湖</el-header>
                <el-container>
                    <el-aside width="100">
                        <el-menu :default-openeds="['1', '3']">
                            <el-submenu index="1">
                                <template slot="title"><i class="el-icon-message"></i>系统信息管理</template>
                                <el-menu-item-group>
                                    <el-menu-item index="1-1">
                                        <router-link to="/dept">门派管理</router-link>
                                    </el-menu-item>
                                    <el-menu-item index="1-2">
                                        <router-link to="/emp">英雄管理</router-link>
                                    </el-menu-item>
                                </el-menu-item-group>
                            </el-submenu>

                        </el-menu>
                    </el-aside>
                    <el-main>
                        <el-table :data="tableData" style="width: 100%">
                            <el-table-column prop="id" label="id" width="180">
                            </el-table-column>
                            <el-table-column prop="name" label="门派" width="180">
                            </el-table-column>
                            <el-table-column prop="createTime" label="创始时间" width="180">
                            </el-table-column>
                            <el-table-column prop="updateTime" label="最后操作时间" width="180">
                            </el-table-column>
                            <el-table-column label="操作">
                                <template slot-scope="scope">
                                    <el-button size="mini"  @click="hqId(scope.row.id)">编辑</el-button>
                                    <el-dialog title="修改门派" :visible.sync="dialogFormVisible">
                                        <el-form :model="form">
                                            <el-form-item  label="门派" :label-width="formLabelWidth">
                                                <el-input v-model="form.name" autocomplete="off"></el-input>
                                            </el-form-item>
                                            <!-- <el-form-item label="最后操作时间" :label-width="formLabelWidth">
                                                <el-date-picker v-model="value1" type="date" placeholder="选择日期">
                                                </el-date-picker>
                                               
                                            </el-form-item> -->
                                        </el-form>
                                        <div slot="footer" class="dialog-footer">
                                            <el-button @click="dialogFormVisible = false">取 消</el-button>
                                            <el-button type="primary" @click="handleEdit()">确 定</el-button>
                                        </div>
                                    </el-dialog>

                                    <el-button size="mini" type="danger" @click="handleDelete(scope.row.id)">删除</el-button>

                                </template>
                            </el-table-column>
                        </el-table>

                    </el-main>
                </el-container>
            </el-container>
        </div>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    data() {
        return {
            tableData: [],
            dialogTableVisible: false,
            dialogFormVisible: false,
            formLabelWidth: "120px",
            ids:"",
            form: {
                name: "",
                
            },
            changeMp:{
                name:""
            }



        }
    },
    methods: {
        sendUrl() {
            axios({
                url: "http://localhost:8080/depts",
                method: "get",
                params: {

                }
            }).then((result) => {
                console.log(result.data)
                this.tableData = result.data.data;
            })
        },
        sendDelId(id) {
            // alert(id)
            axios({
                url: "http://localhost:8080/delDeptId",
                method: "get",
                params: {
                    id: id
                }
            }).then((result) => {
                console.log(result.data.data)
                this.tableData = result.data.data;
                this.sendUrl()
            })
        },

        //编辑
        hqId(id){

            // alert(id)
            this.dialogFormVisible=true
            this.ids=id
        },
        handleEdit() {
            // this.changeMp.name=""
            this.dialogFormVisible=false
            // alert(id)
            // console.log(id)
            console.log(this.form.name)
            // this.changeMp.name=this.form.name
            // this.form.name=""
            axios({
                url: "http://localhost:8080/updateDept",
                method: "get",
                params: {
                    id:this.ids,
                    name:this.form.name
                }
            }).then((result)=>{
                console.log(result)
                this.tableData = result.data.data;
                this.sendUrl()
                this.form.name=""
                // this.changeMp.name=""
            })
        },
        handleDelete(id) {
            // alert(id)
            this.$confirm('此操作将永久删除该部门, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.$message({
                    type: 'success',
                    message: '删除成功!'
                });
                this.sendDelId(id)
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });




        }
    },
    mounted() {
        this.sendUrl();
    }
}


</script>