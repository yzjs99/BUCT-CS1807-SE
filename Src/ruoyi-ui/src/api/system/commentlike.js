import request from '@/utils/request'

// 查询评论点赞列表
export function listCommentlike(query) {
  return request({
    url: '/system/commentlike/list',
    method: 'get',
    params: query
  })
}

// 查询评论点赞详细
export function getCommentlike(id) {
  return request({
    url: '/system/commentlike/' + id,
    method: 'get'
  })
}

// 新增评论点赞
export function addCommentlike(data) {
  return request({
    url: '/system/commentlike',
    method: 'post',
    data: data
  })
}

// 修改评论点赞
export function updateCommentlike(data) {
  return request({
    url: '/system/commentlike',
    method: 'put',
    data: data
  })
}

// 删除评论点赞
export function delCommentlike(id) {
  return request({
    url: '/system/commentlike/' + id,
    method: 'delete'
  })
}

// 导出评论点赞
export function exportCommentlike(query) {
  return request({
    url: '/system/commentlike/export',
    method: 'get',
    params: query
  })
}