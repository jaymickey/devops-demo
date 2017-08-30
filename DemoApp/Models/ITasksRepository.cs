using System.Collections.Generic;
using System.Threading.Tasks;

namespace DemoApp.Models
{
    public interface ITasksRepository
    {
        Task<List<TaskItem>> ListAsync();
        Task AddAsync(TaskItem task);
        Task UpdateAsync(TaskItem task);
        Task DeleteAsync(TaskItem task);
    }
}