using System.Collections.Generic;
using System.Threading.Tasks;

namespace ToDo.Web.Mvc.Models
{
    public interface ITasksRepository
    {
        Task<List<TaskItem>> ListAsync();
        Task AddAsync(TaskItem task);
        Task UpdateAsync(TaskItem task);
        Task DeleteAsync(TaskItem task);
    }
}