<template>
    <div>
        <el-container style="height: 500px; border: 1px solid #eee">
            <el-header style="font-size:40px;background-color:rgb(172, 150, 150)">tlias笑傲江湖</el-header>
            <el-container>
                <el-aside width="200px">
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
                    <el-form :inline="true" :model="formInline" class="demo-form-inline">
                        <el-form-item label="姓名">
                            <el-input v-model="formInline.name" placeholder="姓名"></el-input>
                        </el-form-item>
                        <el-form-item label="性别">
                            <el-select v-model="formInline.gender" placeholder="性别">
                                <el-option label="男" value="1"></el-option>
                                <el-option label="女" value="2"></el-option>
                            </el-select>
                        </el-form-item>

                        <el-form-item>
                            <el-button type="primary" @click="onSubmit">查询</el-button>
                        </el-form-item>
                    </el-form>


                    <el-button type="primary" round @click="dialogFormVisible = true">新增英雄</el-button>

                    <el-dialog title="请输入英雄属性" :visible.sync="dialogFormVisible">
                        <el-form :model="form">
                            <el-form-item label="用户名" :label-width="formLabelWidth">
                                <el-input v-model="form.username" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="姓名" :label-width="formLabelWidth">
                                <el-input v-model="form.name" autocomplete="off"></el-input>
                            </el-form-item>
                            <!-- <el-form-item label="性别" :label-width="formLabelWidth">
                                <el-input v-model="form.gender" autocomplete="off"></el-input>
                            </el-form-item> -->
                            <el-form-item :label-width="formLabelWidth">
                                <el-select v-model="form.gender" placeholder="性别">
                                <el-option label="男" value="1"></el-option>
                                <el-option label="女" value="2"></el-option>
                            </el-select>
                            </el-form-item>
                            
                            <el-form-item label="职位" :label-width="formLabelWidth">
                                <el-input v-model="form.job" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="部门" :label-width="formLabelWidth">
                                <el-input v-model="form.deptId" autocomplete="off"></el-input>
                            </el-form-item>

                        </el-form>
                        <div slot="footer" class="dialog-footer">
                            <el-button @click="dialogFormVisible = false">取 消</el-button>
                            <el-button type="primary" @click="addEmp()">确 定</el-button>
                        </div>
                    </el-dialog>

                    <br>

                    <el-table :data="tableData" border>
                        <el-table-column>
                            <el-checkbox v-model="checked"></el-checkbox>
                        </el-table-column>
                        <el-table-column prop="id" label="id" width="50">
                        </el-table-column>
                        <el-table-column prop="name" label="姓名" width="100"></el-table-column>
                        <el-table-column prop="image" label="图像" width="100"></el-table-column>
                        <el-table-column prop="gender" label="性别" width="60"></el-table-column>
                        <el-table-column prop="job" label="职位" width="60"></el-table-column>
                        <el-table-column prop="entrydate" label="入职日期" width="100"></el-table-column>
                        <el-table-column prop="createTime" label="创建时间" width="150"></el-table-column>
                        <el-table-column prop="updateTime" label="修改时间" width="150"></el-table-column>
                        <el-table-column label="操作" width="150">
                            <el-button type="primary" size="mini">编辑</el-button>
                            <el-button type="danger" size="mini">删除</el-button>
                        </el-table-column>
                    </el-table>
                    <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange"
                        :current-page="currentPage" :page-sizes="[5, 10, 20, 40]" :page-size="100"
                        layout="total, sizes, prev, pager, next, jumper" :total="total">
                    </el-pagination>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data() {
        return {
            dialogTableVisible: false,
            dialogFormVisible: false,
            formLabelWidth: "120px",
            form: {
                username:"" ,
                name: "",
                gender: "",
                job: 1,
                deptId: 1
            },
            tableData: [],
            formInline: {
                name: "",
                gender: "",

            },
            total: 10,
            currentPage: 1,
            pageSize: 5

        }
    },
    methods: {
        sendUrl() {
            axios({
                url: "http://localhost:8080/emps",
                method: "get",
                params: {
                    page: this.currentPage,
                    pageSize: this.pageSize
                }
            }).then((result) => {
                // alert(result.data)
                console.log(result.data)
                console.log(result.data.data.tatol)
                this.tableData = result.data.data.rows
                this.total = result.data.data.tatol
            });
        },
        addEmp: function () {
            this.dialogFormVisible = false
            console.log(this.form)
            axios({
                url: "http://localhost:8080/addEmp",
                method: "get",
                params: {
                    username: this.form.username,
                    name: this.form.name,
                    gender: this.form.gender,
                    job: this.form.job,
                    deptId: this.form.deptId
                }
            }).then((result)=>{
                console.log(result.data)
            })

        },


        onSubmit: function () {
            // alert("查询数据")
            axios({
                url: "http://localhost:8080/empBy",
                method: "get",
                params: {
                    name: this.formInline.name,
                    gender: this.formInline.gender
                }
            }).then((result) => {
                console.log(result.data)
                this.tableData = result.data

            })

        },
        handleSizeChange: function (val) {
            console.log("每页记录数变化" + val);
            this.pageSize = val;
            this.sendUrl();

        },
        handleCurrentChange: function (val) {
            console.log("页码发生变化" + val);
            this.currentPage = val
            // alert(this.currentPage)
            this.sendUrl();

        }
    },
    mounted() {

        this.sendUrl();
    }
}
</script>